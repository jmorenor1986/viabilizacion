
package org.tempuri;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WorkflowEngineSOASoap", targetNamespace = "http://tempuri.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WorkflowEngineSOASoap {


    /**
     * 
     * @param sMessage
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "http://tempuri.org/ping")
    @WebResult(name = "pingResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "ping", targetNamespace = "http://tempuri.org/", className = "org.tempuri.Ping")
    @ResponseWrapper(localName = "pingResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.PingResponse")
    public String ping(
            @WebParam(name = "sMessage", targetNamespace = "http://tempuri.org/")
                    String sMessage);

    /**
     * 
     * @param casesInfo
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "http://tempuri.org/createCasesAsString")
    @WebResult(name = "createCasesAsStringResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "createCasesAsString", targetNamespace = "http://tempuri.org/", className = "org.tempuri.CreateCasesAsString")
    @ResponseWrapper(localName = "createCasesAsStringResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.CreateCasesAsStringResponse")
    public String createCasesAsString(
            @WebParam(name = "casesInfo", targetNamespace = "http://tempuri.org/")
                    String casesInfo);

    /**
     * 
     * @param activityInfo
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "http://tempuri.org/performActivityAsString")
    @WebResult(name = "performActivityAsStringResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "performActivityAsString", targetNamespace = "http://tempuri.org/", className = "org.tempuri.PerformActivityAsString")
    @ResponseWrapper(localName = "performActivityAsStringResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.PerformActivityAsStringResponse")
    public String performActivityAsString(
            @WebParam(name = "activityInfo", targetNamespace = "http://tempuri.org/")
                    String activityInfo);

    /**
     * 
     * @param eventInfo
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "http://tempuri.org/setEventAsString")
    @WebResult(name = "setEventAsStringResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "setEventAsString", targetNamespace = "http://tempuri.org/", className = "org.tempuri.SetEventAsString")
    @ResponseWrapper(localName = "setEventAsStringResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.SetEventAsStringResponse")
    public String setEventAsString(
            @WebParam(name = "eventInfo", targetNamespace = "http://tempuri.org/")
                    String eventInfo);

    /**
     * 
     * @param caseFilters
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "http://tempuri.org/getCasesAsString")
    @WebResult(name = "getCasesAsStringResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "getCasesAsString", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetCasesAsString")
    @ResponseWrapper(localName = "getCasesAsStringResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetCasesAsStringResponse")
    public String getCasesAsString(
            @WebParam(name = "caseFilters", targetNamespace = "http://tempuri.org/")
                    String caseFilters);

    /**
     * 
     * @param activityInfo
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "http://tempuri.org/saveActivityAsString")
    @WebResult(name = "saveActivityAsStringResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "saveActivityAsString", targetNamespace = "http://tempuri.org/", className = "org.tempuri.SaveActivityAsString")
    @ResponseWrapper(localName = "saveActivityAsStringResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.SaveActivityAsStringResponse")
    public String saveActivityAsString(
            @WebParam(name = "activityInfo", targetNamespace = "http://tempuri.org/")
                    String activityInfo);

    /**
     * 
     * @param activityFilters
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "http://tempuri.org/getActivitiesAsString")
    @WebResult(name = "getActivitiesAsStringResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "getActivitiesAsString", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetActivitiesAsString")
    @ResponseWrapper(localName = "getActivitiesAsStringResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetActivitiesAsStringResponse")
    public String getActivitiesAsString(
            @WebParam(name = "activityFilters", targetNamespace = "http://tempuri.org/")
                    String activityFilters);

    /**
     * 
     * @param cases
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "http://tempuri.org/suspendCasesAsString")
    @WebResult(name = "suspendCasesAsStringResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "suspendCasesAsString", targetNamespace = "http://tempuri.org/", className = "org.tempuri.SuspendCasesAsString")
    @ResponseWrapper(localName = "suspendCasesAsStringResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.SuspendCasesAsStringResponse")
    public String suspendCasesAsString(
            @WebParam(name = "cases", targetNamespace = "http://tempuri.org/")
                    String cases);

    /**
     * 
     * @param cases
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "http://tempuri.org/resumeCasesAsString")
    @WebResult(name = "resumeCasesAsStringResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "resumeCasesAsString", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ResumeCasesAsString")
    @ResponseWrapper(localName = "resumeCasesAsStringResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ResumeCasesAsStringResponse")
    public String resumeCasesAsString(
            @WebParam(name = "cases", targetNamespace = "http://tempuri.org/")
                    String cases);

    /**
     * 
     * @param caseInfo
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "http://tempuri.org/getClosedActivitiesAsString")
    @WebResult(name = "getClosedActivitiesAsStringResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "getClosedActivitiesAsString", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetClosedActivitiesAsString")
    @ResponseWrapper(localName = "getClosedActivitiesAsStringResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetClosedActivitiesAsStringResponse")
    public String getClosedActivitiesAsString(
            @WebParam(name = "caseInfo", targetNamespace = "http://tempuri.org/")
                    String caseInfo);

    /**
     * 
     * @param actFilters
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "http://tempuri.org/getEventsAsString")
    @WebResult(name = "getEventsAsStringResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "getEventsAsString", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetEventsAsString")
    @ResponseWrapper(localName = "getEventsAsStringResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetEventsAsStringResponse")
    public String getEventsAsString(
            @WebParam(name = "actFilters", targetNamespace = "http://tempuri.org/")
                    String actFilters);

    /**
     * 
     * @param category
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "http://tempuri.org/getWorkflowClassesAsString")
    @WebResult(name = "getWorkflowClassesAsStringResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "getWorkflowClassesAsString", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetWorkflowClassesAsString")
    @ResponseWrapper(localName = "getWorkflowClassesAsStringResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetWorkflowClassesAsStringResponse")
    public String getWorkflowClassesAsString(
            @WebParam(name = "category", targetNamespace = "http://tempuri.org/")
                    String category);

    /**
     * 
     * @param appName
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "http://tempuri.org/getCategoriesAsString")
    @WebResult(name = "getCategoriesAsStringResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "getCategoriesAsString", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetCategoriesAsString")
    @ResponseWrapper(localName = "getCategoriesAsStringResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetCategoriesAsStringResponse")
    public String getCategoriesAsString(
            @WebParam(name = "appName", targetNamespace = "http://tempuri.org/")
                    String appName);

    /**
     * 
     * @param info
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "http://tempuri.org/abortCasesAsString")
    @WebResult(name = "abortCasesAsStringResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "abortCasesAsString", targetNamespace = "http://tempuri.org/", className = "org.tempuri.AbortCasesAsString")
    @ResponseWrapper(localName = "abortCasesAsStringResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.AbortCasesAsStringResponse")
    public String abortCasesAsString(
            @WebParam(name = "info", targetNamespace = "http://tempuri.org/")
                    String info);

    /**
     * 
     * @param info
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "http://tempuri.org/getAssignationLogAsString")
    @WebResult(name = "getAssignationLogAsStringResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "getAssignationLogAsString", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetAssignationLogAsString")
    @ResponseWrapper(localName = "getAssignationLogAsStringResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetAssignationLogAsStringResponse")
    public String getAssignationLogAsString(
            @WebParam(name = "info", targetNamespace = "http://tempuri.org/")
                    String info);

    /**
     * 
     * @param sDomain
     * @param sUserName
     * @param sPassword
     * @return
     *     returns int
     */
    @WebMethod(operationName = "CheckPassword", action = "http://tempuri.org/CheckPassword")
    @WebResult(name = "CheckPasswordResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "CheckPassword", targetNamespace = "http://tempuri.org/", className = "org.tempuri.CheckPassword")
    @ResponseWrapper(localName = "CheckPasswordResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.CheckPasswordResponse")
    public int checkPassword(
            @WebParam(name = "sDomain", targetNamespace = "http://tempuri.org/")
                    String sDomain,
            @WebParam(name = "sUserName", targetNamespace = "http://tempuri.org/")
                    String sUserName,
            @WebParam(name = "sPassword", targetNamespace = "http://tempuri.org/")
                    String sPassword);

    /**
     * 
     * @param info
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "http://tempuri.org/assignActivityAsString")
    @WebResult(name = "assignActivityAsStringResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "assignActivityAsString", targetNamespace = "http://tempuri.org/", className = "org.tempuri.AssignActivityAsString")
    @ResponseWrapper(localName = "assignActivityAsStringResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.AssignActivityAsStringResponse")
    public String assignActivityAsString(
            @WebParam(name = "info", targetNamespace = "http://tempuri.org/")
                    String info);

    /**
     * 
     * @param caseAccessXML
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "http://tempuri.org/grantCaseAccess")
    @WebResult(name = "grantCaseAccessResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "grantCaseAccess", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GrantCaseAccess")
    @ResponseWrapper(localName = "grantCaseAccessResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GrantCaseAccessResponse")
    public String grantCaseAccess(
            @WebParam(name = "caseAccessXML", targetNamespace = "http://tempuri.org/")
                    String caseAccessXML);

    /**
     * 
     * @param caseAccessXML
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "http://tempuri.org/revokeCaseAccess")
    @WebResult(name = "revokeCaseAccessResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "revokeCaseAccess", targetNamespace = "http://tempuri.org/", className = "org.tempuri.RevokeCaseAccess")
    @ResponseWrapper(localName = "revokeCaseAccessResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.RevokeCaseAccessResponse")
    public String revokeCaseAccess(
            @WebParam(name = "caseAccessXML", targetNamespace = "http://tempuri.org/")
                    String caseAccessXML);

    /**
     * 
     * @param caseInfo
     * @return
     *     returns org.tempuri.CleanTestDataResponse.CleanTestDataResult
     */
    @WebMethod(action = "http://tempuri.org/cleanTestData")
    @WebResult(name = "cleanTestDataResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "cleanTestData", targetNamespace = "http://tempuri.org/", className = "org.tempuri.CleanTestData")
    @ResponseWrapper(localName = "cleanTestDataResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.CleanTestDataResponse")
    public org.tempuri.CleanTestDataResponse.CleanTestDataResult cleanTestData(
            @WebParam(name = "caseInfo", targetNamespace = "http://tempuri.org/")
                    org.tempuri.CleanTestData.CaseInfo caseInfo);

    /**
     * 
     * @param casesInfo
     * @return
     *     returns org.tempuri.CreateCasesResponse.CreateCasesResult
     */
    @WebMethod(action = "http://tempuri.org/createCases")
    @WebResult(name = "createCasesResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "createCases", targetNamespace = "http://tempuri.org/", className = "org.tempuri.CreateCases")
    @ResponseWrapper(localName = "createCasesResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.CreateCasesResponse")
    public org.tempuri.CreateCasesResponse.CreateCasesResult createCases(
            @WebParam(name = "casesInfo", targetNamespace = "http://tempuri.org/")
                    org.tempuri.CreateCases.CasesInfo casesInfo);

    /**
     * 
     * @param assertionInfo
     * @return
     *     returns org.tempuri.EvalRuleResponse.EvalRuleResult
     */
    @WebMethod(action = "http://tempuri.org/evalRule")
    @WebResult(name = "evalRuleResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "evalRule", targetNamespace = "http://tempuri.org/", className = "org.tempuri.EvalRule")
    @ResponseWrapper(localName = "evalRuleResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.EvalRuleResponse")
    public org.tempuri.EvalRuleResponse.EvalRuleResult evalRule(
            @WebParam(name = "assertionInfo", targetNamespace = "http://tempuri.org/")
                    org.tempuri.EvalRule.AssertionInfo assertionInfo);

    /**
     * 
     * @param activitiesFilters
     * @return
     *     returns org.tempuri.GetActivitiesResponse.GetActivitiesResult
     */
    @WebMethod(action = "http://tempuri.org/getActivities")
    @WebResult(name = "getActivitiesResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "getActivities", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetActivities")
    @ResponseWrapper(localName = "getActivitiesResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetActivitiesResponse")
    public org.tempuri.GetActivitiesResponse.GetActivitiesResult getActivities(
            @WebParam(name = "activitiesFilters", targetNamespace = "http://tempuri.org/")
                    org.tempuri.GetActivities.ActivitiesFilters activitiesFilters);

    /**
     * 
     * @param caseInfo
     * @return
     *     returns org.tempuri.GetAssignationLogResponse.GetAssignationLogResult
     */
    @WebMethod(action = "http://tempuri.org/getAssignationLog")
    @WebResult(name = "getAssignationLogResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "getAssignationLog", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetAssignationLog")
    @ResponseWrapper(localName = "getAssignationLogResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetAssignationLogResponse")
    public org.tempuri.GetAssignationLogResponse.GetAssignationLogResult getAssignationLog(
            @WebParam(name = "caseInfo", targetNamespace = "http://tempuri.org/")
                    org.tempuri.GetAssignationLog.CaseInfo caseInfo);

    /**
     * 
     * @param caseInfo
     * @return
     *     returns org.tempuri.GetClosedActivitiesResponse.GetClosedActivitiesResult
     */
    @WebMethod(action = "http://tempuri.org/getClosedActivities")
    @WebResult(name = "getClosedActivitiesResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "getClosedActivities", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetClosedActivities")
    @ResponseWrapper(localName = "getClosedActivitiesResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetClosedActivitiesResponse")
    public org.tempuri.GetClosedActivitiesResponse.GetClosedActivitiesResult getClosedActivities(
            @WebParam(name = "caseInfo", targetNamespace = "http://tempuri.org/")
                    org.tempuri.GetClosedActivities.CaseInfo caseInfo);

    /**
     * 
     * @param activityInfo
     * @return
     *     returns org.tempuri.PerformActivityResponse.PerformActivityResult
     */
    @WebMethod(action = "http://tempuri.org/performActivity")
    @WebResult(name = "performActivityResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "performActivity", targetNamespace = "http://tempuri.org/", className = "org.tempuri.PerformActivity")
    @ResponseWrapper(localName = "performActivityResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.PerformActivityResponse")
    public org.tempuri.PerformActivityResponse.PerformActivityResult performActivity(
            @WebParam(name = "activityInfo", targetNamespace = "http://tempuri.org/")
                    org.tempuri.PerformActivity.ActivityInfo activityInfo);

    /**
     * 
     * @param cases
     * @return
     *     returns org.tempuri.ResumeCasesResponse.ResumeCasesResult
     */
    @WebMethod(action = "http://tempuri.org/resumeCases")
    @WebResult(name = "resumeCasesResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "resumeCases", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ResumeCases")
    @ResponseWrapper(localName = "resumeCasesResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ResumeCasesResponse")
    public ResumeCasesResponse.ResumeCasesResult resumeCases(
            @WebParam(name = "cases", targetNamespace = "http://tempuri.org/")
                    org.tempuri.ResumeCases.Cases cases);

    /**
     * 
     * @param caseInfo
     * @return
     *     returns org.tempuri.RollbackCaseResponse.RollbackCaseResult
     */
    @WebMethod(action = "http://tempuri.org/rollbackCase")
    @WebResult(name = "rollbackCaseResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "rollbackCase", targetNamespace = "http://tempuri.org/", className = "org.tempuri.RollbackCase")
    @ResponseWrapper(localName = "rollbackCaseResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.RollbackCaseResponse")
    public RollbackCaseResponse.RollbackCaseResult rollbackCase(
            @WebParam(name = "caseInfo", targetNamespace = "http://tempuri.org/")
                    RollbackCase.CaseInfo caseInfo);

    /**
     * 
     * @param eventInfo
     * @return
     *     returns org.tempuri.SetEventResponse.SetEventResult
     */
    @WebMethod(action = "http://tempuri.org/setEvent")
    @WebResult(name = "setEventResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "setEvent", targetNamespace = "http://tempuri.org/", className = "org.tempuri.SetEvent")
    @ResponseWrapper(localName = "setEventResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.SetEventResponse")
    public SetEventResponse.SetEventResult setEvent(
            @WebParam(name = "eventInfo", targetNamespace = "http://tempuri.org/")
                    SetEvent.EventInfo eventInfo);

    /**
     * 
     * @param cases
     * @return
     *     returns org.tempuri.SuspendCasesResponse.SuspendCasesResult
     */
    @WebMethod(action = "http://tempuri.org/suspendCases")
    @WebResult(name = "suspendCasesResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "suspendCases", targetNamespace = "http://tempuri.org/", className = "org.tempuri.SuspendCases")
    @ResponseWrapper(localName = "suspendCasesResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.SuspendCasesResponse")
    public SuspendCasesResponse.SuspendCasesResult suspendCases(
            @WebParam(name = "cases", targetNamespace = "http://tempuri.org/")
                    SuspendCases.Cases cases);

    /**
     * 
     * @param casesInfo
     * @return
     *     returns org.tempuri.AbortCasesResponse.AbortCasesResult
     */
    @WebMethod(action = "http://tempuri.org/abortCases")
    @WebResult(name = "abortCasesResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "abortCases", targetNamespace = "http://tempuri.org/", className = "org.tempuri.AbortCases")
    @ResponseWrapper(localName = "abortCasesResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.AbortCasesResponse")
    public org.tempuri.AbortCasesResponse.AbortCasesResult abortCases(
            @WebParam(name = "casesInfo", targetNamespace = "http://tempuri.org/")
                    org.tempuri.AbortCases.CasesInfo casesInfo);

    /**
     * 
     * @return
     *     returns org.tempuri.GetApplicationsResponse.GetApplicationsResult
     */
    @WebMethod(action = "http://tempuri.org/getApplications")
    @WebResult(name = "getApplicationsResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "getApplications", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetApplications")
    @ResponseWrapper(localName = "getApplicationsResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetApplicationsResponse")
    public org.tempuri.GetApplicationsResponse.GetApplicationsResult getApplications();

    /**
     * 
     * @param application
     * @return
     *     returns org.tempuri.GetCategoriesResponse.GetCategoriesResult
     */
    @WebMethod(action = "http://tempuri.org/getCategories")
    @WebResult(name = "getCategoriesResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "getCategories", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetCategories")
    @ResponseWrapper(localName = "getCategoriesResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetCategoriesResponse")
    public org.tempuri.GetCategoriesResponse.GetCategoriesResult getCategories(
            @WebParam(name = "application", targetNamespace = "http://tempuri.org/")
                    org.tempuri.GetCategories.Application application);

    /**
     * 
     * @param applicationName
     * @return
     *     returns org.tempuri.GetCategories2Response.GetCategories2Result
     */
    @WebMethod(action = "http://tempuri.org/getCategories2")
    @WebResult(name = "getCategories2Result", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "getCategories2", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetCategories2")
    @ResponseWrapper(localName = "getCategories2Response", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetCategories2Response")
    public org.tempuri.GetCategories2Response.GetCategories2Result getCategories2(
            @WebParam(name = "applicationName", targetNamespace = "http://tempuri.org/")
                    String applicationName);

    /**
     * 
     * @param applicationName
     * @return
     *     returns org.tempuri.GetCategoriesFromApplicationNameResponse.GetCategoriesFromApplicationNameResult
     */
    @WebMethod(action = "http://tempuri.org/getCategoriesFromApplicationName")
    @WebResult(name = "getCategoriesFromApplicationNameResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "getCategoriesFromApplicationName", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetCategoriesFromApplicationName")
    @ResponseWrapper(localName = "getCategoriesFromApplicationNameResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetCategoriesFromApplicationNameResponse")
    public org.tempuri.GetCategoriesFromApplicationNameResponse.GetCategoriesFromApplicationNameResult getCategoriesFromApplicationName(
            @WebParam(name = "applicationName", targetNamespace = "http://tempuri.org/")
                    String applicationName);

    /**
     * 
     * @param categoryName
     * @return
     *     returns org.tempuri.GetWorkflowClassesFromCategoryNameResponse.GetWorkflowClassesFromCategoryNameResult
     */
    @WebMethod(action = "http://tempuri.org/getWorkflowClassesFromCategoryName")
    @WebResult(name = "getWorkflowClassesFromCategoryNameResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "getWorkflowClassesFromCategoryName", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetWorkflowClassesFromCategoryName")
    @ResponseWrapper(localName = "getWorkflowClassesFromCategoryNameResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetWorkflowClassesFromCategoryNameResponse")
    public org.tempuri.GetWorkflowClassesFromCategoryNameResponse.GetWorkflowClassesFromCategoryNameResult getWorkflowClassesFromCategoryName(
            @WebParam(name = "categoryName", targetNamespace = "http://tempuri.org/")
                    String categoryName);

    /**
     * 
     * @param cultureName
     * @param applicationName
     * @return
     *     returns org.tempuri.GetCategoriesLocalizedResponse.GetCategoriesLocalizedResult
     */
    @WebMethod(action = "http://tempuri.org/getCategoriesLocalized")
    @WebResult(name = "getCategoriesLocalizedResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "getCategoriesLocalized", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetCategoriesLocalized")
    @ResponseWrapper(localName = "getCategoriesLocalizedResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetCategoriesLocalizedResponse")
    public org.tempuri.GetCategoriesLocalizedResponse.GetCategoriesLocalizedResult getCategoriesLocalized(
            @WebParam(name = "applicationName", targetNamespace = "http://tempuri.org/")
                    String applicationName,
            @WebParam(name = "cultureName", targetNamespace = "http://tempuri.org/")
                    String cultureName);

    /**
     * 
     * @param category
     * @return
     *     returns org.tempuri.GetWorkflowClassesResponse.GetWorkflowClassesResult
     */
    @WebMethod(action = "http://tempuri.org/getWorkflowClasses")
    @WebResult(name = "getWorkflowClassesResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "getWorkflowClasses", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetWorkflowClasses")
    @ResponseWrapper(localName = "getWorkflowClassesResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetWorkflowClassesResponse")
    public org.tempuri.GetWorkflowClassesResponse.GetWorkflowClassesResult getWorkflowClasses(
            @WebParam(name = "category", targetNamespace = "http://tempuri.org/")
                    org.tempuri.GetWorkflowClasses.Category category);

    /**
     * 
     * @param categoryName
     * @return
     *     returns org.tempuri.GetWorkflowClasses2Response.GetWorkflowClasses2Result
     */
    @WebMethod(action = "http://tempuri.org/getWorkflowClasses2")
    @WebResult(name = "getWorkflowClasses2Result", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "getWorkflowClasses2", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetWorkflowClasses2")
    @ResponseWrapper(localName = "getWorkflowClasses2Response", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetWorkflowClasses2Response")
    public org.tempuri.GetWorkflowClasses2Response.GetWorkflowClasses2Result getWorkflowClasses2(
            @WebParam(name = "categoryName", targetNamespace = "http://tempuri.org/")
                    String categoryName);

    /**
     * 
     * @param activitiesFilters
     * @return
     *     returns org.tempuri.GetEventsResponse.GetEventsResult
     */
    @WebMethod(action = "http://tempuri.org/getEvents")
    @WebResult(name = "getEventsResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "getEvents", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetEvents")
    @ResponseWrapper(localName = "getEventsResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetEventsResponse")
    public org.tempuri.GetEventsResponse.GetEventsResult getEvents(
            @WebParam(name = "activitiesFilters", targetNamespace = "http://tempuri.org/")
                    org.tempuri.GetEvents.ActivitiesFilters activitiesFilters);

    /**
     * 
     * @param casesFilters
     * @return
     *     returns org.tempuri.GetCasesResponse.GetCasesResult
     */
    @WebMethod(action = "http://tempuri.org/getCases")
    @WebResult(name = "getCasesResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "getCases", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetCases")
    @ResponseWrapper(localName = "getCasesResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetCasesResponse")
    public org.tempuri.GetCasesResponse.GetCasesResult getCases(
            @WebParam(name = "casesFilters", targetNamespace = "http://tempuri.org/")
                    org.tempuri.GetCases.CasesFilters casesFilters);

    /**
     * 
     * @param activityInfo
     * @return
     *     returns org.tempuri.SaveActivityResponse.SaveActivityResult
     */
    @WebMethod(action = "http://tempuri.org/saveActivity")
    @WebResult(name = "saveActivityResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "saveActivity", targetNamespace = "http://tempuri.org/", className = "org.tempuri.SaveActivity")
    @ResponseWrapper(localName = "saveActivityResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.SaveActivityResponse")
    public SaveActivityResponse.SaveActivityResult saveActivity(
            @WebParam(name = "activityInfo", targetNamespace = "http://tempuri.org/")
                    SaveActivity.ActivityInfo activityInfo);

    /**
     * 
     * @param xmlDoc
     * @return
     *     returns org.tempuri.AssignActivityResponse.AssignActivityResult
     */
    @WebMethod(action = "http://tempuri.org/assignActivity")
    @WebResult(name = "assignActivityResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "assignActivity", targetNamespace = "http://tempuri.org/", className = "org.tempuri.AssignActivity")
    @ResponseWrapper(localName = "assignActivityResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.AssignActivityResponse")
    public org.tempuri.AssignActivityResponse.AssignActivityResult assignActivity(
            @WebParam(name = "xmlDoc", targetNamespace = "http://tempuri.org/")
                    org.tempuri.AssignActivity.XmlDoc xmlDoc);

}