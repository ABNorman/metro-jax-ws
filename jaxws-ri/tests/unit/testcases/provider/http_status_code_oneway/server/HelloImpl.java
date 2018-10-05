/*
 * Copyright (c) 2004, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

/*
 * Hello_Impl.java
 *
 * Created on July 25, 2003, 10:37 AM
 */

package provider.http_status_code_oneway.server;

import java.rmi.Remote;
import javax.xml.ws.Provider;
import javax.xml.ws.Service;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.util.Iterator;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.Service.Mode;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.MimeHeader;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.WebServiceProvider;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.annotation.Resource;
import java.io.StringReader;

import org.w3c.dom.Node;

/**
 * @author Jitendra Kotamraju
 */
@WebServiceProvider
@ServiceMode(value=Service.Mode.PAYLOAD)
public class HelloImpl implements Provider<Source> {

    @Resource
    WebServiceContext wsCtxt;

    public Source invoke(Source msg) {
        MessageContext msgCtxt = wsCtxt.getMessageContext();        
        msgCtxt.put(MessageContext.HTTP_RESPONSE_CODE, 502);
        return new StreamSource(new StringReader("<foo/>"));
    }
}
