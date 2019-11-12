/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Camunda licenses this file to you under the Apache License,
 * Version 2.0; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.getstarted.loanapproval;

import java.io.FileNotFoundException;

import org.camunda.bpm.dmn.engine.DmnDecisionResult;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.repository.Deployment;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebappExampleProcessApplication {

  public static void main(String... args) throws FileNotFoundException {
    SpringApplication.run(WebappExampleProcessApplication.class, args);
    
    ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
    
    String resourceName = "diagram_test.dmn";
    Deployment deployment = processEngine
      .getRepositoryService()
      .createDeployment()
      .addClasspathResource(resourceName)
      .deploy();
    
//    DmnEngine dmnEngine = DmnEngineConfiguration
//    		  .createDefaultDmnEngineConfiguration()
//    		  .buildEngine();
    
	//InputStream inputStream = new FileInputStream("/loan-approval-spring-boot/diagram_test.dmn"); 
    org.camunda.bpm.engine.DecisionService decisionService = processEngine.getDecisionService();
    VariableMap variables = Variables.createVariables()
            .putValue("name", "Jatin")
            .putValue("date", "2019-11-05T12:00:00")
            .putValue("email", "mahajanjatin14@gmail.com");
    DmnDecisionResult decisionResult = decisionService
    		  .evaluateDecisionByKey("decisionTest")
    		  .variables(variables)
    		  .evaluate(); 
    
   
     System.out.println("result : " + decisionResult);
    
  }

}