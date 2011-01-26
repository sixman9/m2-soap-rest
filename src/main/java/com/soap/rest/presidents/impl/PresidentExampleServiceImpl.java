package com.soap.rest.presidents.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.context.ServletContextAware;

import com.soap.rest.service.PresidentExampleServiceIntf;

//Spring-based annotation - this means it will be available to Spring code with added to Spring-xml config(s)
@Service("presidentService")
public class PresidentExampleServiceImpl implements
        PresidentExampleServiceIntf, ServletContextAware {

    // Use the servlet context to access resource/property files etc.
    ServletContext servletContext;

    // Get Spring to give us a bean or service etc. etc.
    @Autowired
    @Qualifier("h2.database.dataSource")
    private DataSource datasource;

    // For example purposes - access a (in-memory) database (H2)
    private Connection connection;

    private Statement dbStatement;

    private String csvFileName = "uspresidents.csv";

    @PostConstruct
    public void afterBeanInjection() {
        // As the constructor will have been called before Injection, we might
        // want to do some setup, here
        try {
            connection = datasource.getConnection();
            dbStatement = connection.createStatement();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    @Override
    public String getPresidentByNumber(int presidentInt) {
        String presidentName = "Not found";
        try {
            ResultSet rs = dbStatement.executeQuery("SELECT * FROM CSVREAD('"
                    + csvFileName + "') AS csv " + "WHERE csv.Presidency = "
                    + presidentInt + " "
                    // + "AND " + presidentInt + "<= MAX(csv.Presidency)"
                    + ";");

            while (rs.next()) {
                String nextResultColumn2 = rs.getString(2); // Get String value
                                                            // from
                                                            // column 2 of
                                                            // result
                                                            // set
                presidentName = nextResultColumn2;
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return presidentName;
    }

    @Override
    public List<String> getPresidentsByName(String nameSearch) {
        List<String> presidentData = new ArrayList<String>();

        if (StringUtils.hasText(nameSearch)) {
            try {
                ResultSet rs = dbStatement
                        .executeQuery("SELECT * FROM CSVREAD('" + csvFileName
                                + "') AS csv "
                                + "WHERE LOWER(csv.President) LIKE LOWER('%"
                                + nameSearch + "%')" + ";");

                while (rs.next()) {
                    String nextResultColumn2 = rs.getString(2); // Get String
                                                                // value
                                                                // from
                                                                // column 2 of
                                                                // result
                                                                // set
                    presidentData.add(nextResultColumn2);
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }

        return presidentData;
    }

    @Override
    public void setServletContext(ServletContext _servletContext) {
        this.servletContext = _servletContext;

        // Replace cvsFileName with the actual path to that file
        csvFileName = servletContext.getRealPath("/WEB-INF/classes/"
                + csvFileName);
    }

}
