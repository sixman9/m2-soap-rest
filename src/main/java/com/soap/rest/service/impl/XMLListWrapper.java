package com.soap.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//Wrapper object for List<String> and JAX-RS/Rest
@XmlRootElement(name = "wrappedElements")
public class XMLListWrapper {

    @XmlElement(name = "element")
    List<?> list;

    // no-arg Constructor (Java bean)
    public XMLListWrapper() {
    }

    public <T> void add(List<T> _list) {
        if (_list != null) {
            this.list = _list;
        } else {
            // Empty list
            list = new ArrayList<T>();
        }
    }
}