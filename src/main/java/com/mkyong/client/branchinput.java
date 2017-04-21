/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mkyong.client;


import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class branchinput {
int branchid;
int phonenumber;

	public static void main(String[] args) {
            branchinput  obj = new branchinput();
            
            Gson gson = new Gson();
            
            String json = gson.toJson(obj);

		try {

			Client client = Client.create();

			WebResource webResource = client
                                .resource("http://localhost:8080/api/branch");
         

			ClientResponse response = webResource.type("application/json")
					.post(ClientResponse.class, json);

			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			System.out.println("Output from Server .... \n");
			String output = response.getEntity(String.class);
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
