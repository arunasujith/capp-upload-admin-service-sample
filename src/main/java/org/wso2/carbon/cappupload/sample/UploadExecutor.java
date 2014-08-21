/*
*Copyright (c) 2005-2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*WSO2 Inc. licenses this file to you under the Apache License,
*Version 2.0 (the "License"); you may not use this file except
*in compliance with the License.
*You may obtain a copy of the License at
*
*http://www.apache.org/licenses/LICENSE-2.0
*
*Unless required by applicable law or agreed to in writing,
*software distributed under the License is distributed on an
*"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
*KIND, either express or implied.  See the License for the
*specific language governing permissions and limitations
*under the License.
*/
package org.wso2.carbon.cappupload.sample;

import javax.activation.DataHandler;
import java.net.URL;

public class UploadExecutor {

	public static void main(String[] args) throws Exception {
		setKeyStoreProperties();

		//org.apache.log4j.BasicConfigurator.configure();

		String backendURL = "https://localhost:9443/services/";

		AuthenticatorClient authenticatorClient = new AuthenticatorClient(backendURL);

		String sessionCookie = authenticatorClient.login("admin", "admin", "localhost");

		CarbonAppUploaderClient carbonAppUploaderClient = new CarbonAppUploaderClient(backendURL, sessionCookie);

		//set the file path
		DataHandler dataHandler = new DataHandler(new URL
				("file:///home/aruna/Downloads/Sample_CApp_1.0.0.car"));
		//set the capp name
		carbonAppUploaderClient.uploadCarbonAppArtifact("Sample_CApp_1.0.0.car", dataHandler);
	}

	public static void setKeyStoreProperties() throws Exception {
		System.setProperty("javax.net.ssl.trustStore", "/home/aruna/wso2//wso2esb-4.8" +
		                                               ".1/repository/resources/security/wso2carbon.jks");
		System.setProperty("javax.net.ssl.trustStorePassword", "wso2carbon");
		System.setProperty("javax.net.ssl.trustStoreType", "JKS");
	}
}

