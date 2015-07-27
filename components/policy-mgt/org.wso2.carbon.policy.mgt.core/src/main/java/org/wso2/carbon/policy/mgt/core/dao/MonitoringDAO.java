/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */


package org.wso2.carbon.policy.mgt.core.dao;

import org.wso2.carbon.policy.mgt.common.monitor.ComplianceData;
import org.wso2.carbon.policy.mgt.common.monitor.ComplianceFeature;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface MonitoringDAO {

    int addComplianceDetails(int deviceId, int policyId) throws MonitoringDAOException;

    /**
     * This is getting a list of values with device id and applied policy
     * @param devicePolicyMap <Device Id, Policy Id>
     * @throws MonitoringDAOException
     */
    void addComplianceDetails(Map<Integer, Integer> devicePolicyMap) throws MonitoringDAOException;

    int setDeviceAsNoneCompliance(int deviceId, int policyId) throws MonitoringDAOException;

    int setDeviceAsCompliance(int deviceId, int policyId) throws MonitoringDAOException;

    void addNoneComplianceFeatures(int policyComplianceStatusId, int deviceId, List<ComplianceFeature>
            complianceFeatures)
            throws MonitoringDAOException;

    ComplianceData getCompliance(int deviceId) throws MonitoringDAOException;

    List<ComplianceData> getCompliance(List<Integer> deviceIds) throws MonitoringDAOException;

    List<ComplianceFeature> getNoneComplianceFeatures(int policyComplianceStatusId) throws MonitoringDAOException;

    void deleteNoneComplianceData(int policyComplianceStatusId) throws MonitoringDAOException;

    void updateAttempts(int deviceId, boolean reset) throws MonitoringDAOException;

    void updateAttempts(List<Integer> deviceId, boolean reset) throws MonitoringDAOException;


}
