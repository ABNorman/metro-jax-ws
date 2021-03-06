/*
 * Copyright (c) 1997, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package bugs.jaxws620.server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * TODO: Write some description here ...
 *
 * @author Miroslav Kos (miroslav.kos at oracle.com)
 */
@WebService(name = "AddNumbers", targetNamespace = "http://duke.example.org")
public class AddNumbersImpl implements AddNumbers {

    @WebMethod
    @WebResult(targetNamespace = "http://duke.example.org")
    @RequestWrapper(localName = "addNumbers", targetNamespace = "http://duke.example.org", className = "dispatch.generate.client.AddNumbers")
    @ResponseWrapper(localName = "addNumbersResponse", targetNamespace = "http://duke.example.org", className = "dispatch.generate.client.AddNumbersResponse")
    public int addNumbers(
            @WebParam(name = "arg0", targetNamespace = "http://duke.example.org")
            int arg0,
            @WebParam(name = "arg1", targetNamespace = "http://duke.example.org")
            int arg1) {

        return arg0 + arg1;
    }
}
