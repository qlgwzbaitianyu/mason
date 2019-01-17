package com.luxottica.ria.services.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.luxottica.ria.commonformat.dto.benefit.GetBenefitsNarrativeRequestDto;
import com.luxottica.ria.commonformat.dto.benefit.GetBenefitsNarrativeResponseDto;
import com.luxottica.ria.commonformat.dto.doctor.DoctorDataRequestDto;
import com.luxottica.ria.commonformat.dto.doctor.DoctorDataResponseDto;
import com.luxottica.ria.commonformat.dto.eligibility.GetRetailEligibilityRequestDto;
import com.luxottica.ria.commonformat.dto.eligibility.GetRetailEligibilityResponseDto;
import com.luxottica.ria.commonformat.dto.general.GetBenefitLevelsRequestDto;
import com.luxottica.ria.commonformat.dto.general.GetBenefitLevelsResponseDto;
import com.luxottica.ria.commonformat.dto.general.POSSubmitClaimRequestDto;
import com.luxottica.ria.commonformat.dto.general.POSSubmitClaimResponseDto;
import com.luxottica.ria.commonformat.dto.member.FindRetailMembersRequestDto;
import com.luxottica.ria.commonformat.dto.member.FindRetailMembersResponseDto;
import com.luxottica.ria.commonformat.dto.member.GetRetailMemberRequestDto;
import com.luxottica.ria.commonformat.dto.member.GetRetailMemberResponseDto;
import com.luxottica.ria.commonformat.dto.member.OnlineCustomerRequestDto;
import com.luxottica.ria.commonformat.dto.member.OnlineCustomerResponseDto;
import com.luxottica.ria.commonformat.dto.plan.FindRetailPlansRequestDto;
import com.luxottica.ria.commonformat.dto.plan.FindRetailPlansResponseDto;
import com.luxottica.ria.commonformat.dto.plan.GetRetailPlanRequestDto;
import com.luxottica.ria.commonformat.dto.plan.GetRetailPlanResponseDto;
import com.luxottica.ria.commonformat.dto.priceclaim.GetRetailBenefitPricingRequestDto;
import com.luxottica.ria.commonformat.dto.priceclaim.GetRetailBenefitPricingResponseDto;
import com.luxottica.ria.commonformat.dto.priceclaim.VoidRetailClaimRequestDto;
import com.luxottica.ria.commonformat.dto.priceclaim.VoidRetailClaimResponseDto;
import com.luxottica.ria.commonformat.dto.tender.GetTenderStatusRequestDto;
import com.luxottica.ria.commonformat.dto.tender.GetTenderStatusResponseDto;
import com.luxottica.ria.commonformat.dto.token.GetNewTokenRequestDto;
import com.luxottica.ria.commonformat.dto.token.GetNewTokenResponseDto;
/***
 *
 * @author Antonio Magnocavallo
 *
 */
@WebService(name = "InsuranceAdapter", targetNamespace = "http://luxotticaretail.services.com/Adapter/Insurance")
@SOAPBinding(style = Style.DOCUMENT)
public interface InsuranceAdapterInterface {

    @WebMethod (operationName = "GetTenderStatus")
    @WebResult(name = "GetTenderStatusResponseDto", partName = "GetTenderStatusResponseDto")
    GetTenderStatusResponseDto getTenderStatus(@WebParam(name = "getTenderStatusRequestDto", targetNamespace = "http://luxotticaretail.services.com/Adapter/Insurance")GetTenderStatusRequestDto input);

    @WebMethod (operationName = "GetNewToken")
    @WebResult(name = "GetNewTokenResponseDto", partName = "GetNewTokenResponseDto")
    GetNewTokenResponseDto getNewToken(@WebParam(name = "getNewTokenRequestDto", targetNamespace = "http://luxotticaretail.services.com/Adapter/Insurance")GetNewTokenRequestDto input);

    @WebMethod (operationName = "DoctorData")
    @WebResult(name = "DoctorDataResponseDto", partName = "DoctorDataResponseDto")
    DoctorDataResponseDto doctorData(@WebParam(name = "doctorDataRequestDto", targetNamespace = "http://luxotticaretail.services.com/Adapter/Insurance")DoctorDataRequestDto input);

    @WebMethod (operationName = "FindMembers")
    @WebResult(name = "FindRetailMembersResponseDto", partName = "FindRetailMembersResponseDto")
    FindRetailMembersResponseDto findMembers(@WebParam(name = "findRetailMembersRequestDtoInput", targetNamespace = "http://luxotticaretail.services.com/Adapter/Insurance")FindRetailMembersRequestDto input);

    @WebMethod (operationName = "GetMember")
    @WebResult(name = "GetRetailMemberResponseDto", partName = "GetRetailMemberResponseDto")
    GetRetailMemberResponseDto getMember(@WebParam(name = "getRetailMemberRequestDtoInput", targetNamespace = "http://luxotticaretail.services.com/Adapter/Insurance") GetRetailMemberRequestDto input);

    @WebMethod (operationName = "GetBenefitsNarrative")
    @WebResult(name = "GetBenefitsNarrativeResponseDto", partName = "GetBenefitsNarrativeResponseDto")
    GetBenefitsNarrativeResponseDto getBenefitsNarrative(@WebParam(name = "getBenefitsNarrativeRequestDtoInput", targetNamespace = "http://luxotticaretail.services.com/Adapter/Insurance")GetBenefitsNarrativeRequestDto input);

    @WebMethod (operationName = "GetMemberEligibility")
    @WebResult(name = "GetRetailEligibilityResponseDto", partName = "GetRetailEligibilityResponseDto")
    GetRetailEligibilityResponseDto getMemberEligibility(@WebParam(name = "getRetailEligibilityRequestDtoInput", targetNamespace = "http://luxotticaretail.services.com/Adapter/Insurance")GetRetailEligibilityRequestDto input);

    @WebMethod (operationName = "POSSubmitClaim")
    @WebResult(name = "POSSubmitClaimResponseDto", partName = "POSSubmitClaimResponseDto")
    POSSubmitClaimResponseDto posSubmitClaim(@WebParam(name = "POSSubmitClaimRequestDtoInput", targetNamespace = "http://luxotticaretail.services.com/Adapter/Insurance")POSSubmitClaimRequestDto input);

    @WebMethod (operationName = "GetPlan")
    @WebResult(name = "GetRetailPlanResponseDto", partName = "GetRetailPlanResponseDto")
    GetRetailPlanResponseDto getPlan(@WebParam(name = "getRetailPlanRequestDtoInput", targetNamespace = "http://luxotticaretail.services.com/Adapter/Insurance")GetRetailPlanRequestDto input);

    @WebMethod (operationName = "PriceClaim")
    @WebResult(name = "GetRetailBenefitPricingResponseDto", partName = "GetRetailBenefitPricingResponseDto")
    GetRetailBenefitPricingResponseDto priceClaim(@WebParam(name = "getRetailBenefitPricingRequestDto", targetNamespace = "http://luxotticaretail.services.com/Adapter/Insurance")GetRetailBenefitPricingRequestDto input);

    @WebMethod (operationName = "GetBenefitLevels")
    @WebResult(name = "GetBenefitLevelsResponseDto", partName = "GetBenefitLevelsResponseDto")
    GetBenefitLevelsResponseDto getBenefitLevels(@WebParam(name = "getBenefitLevels", targetNamespace = "http://luxotticaretail.services.com/Adapter/Insurance")GetBenefitLevelsRequestDto input);

    @WebMethod (operationName = "FindRetailPlans")
    @WebResult(name = "FindRetailPlansResponseDto", partName = "FindRetailPlansResponseDto")
    FindRetailPlansResponseDto findRetailPlans(@WebParam(name = "findRetailPlans", targetNamespace = "http://luxotticaretail.services.com/Adapter/Insurance")FindRetailPlansRequestDto input);

    @WebMethod (operationName = "VoidRetailClaim")
    @WebResult(name = "VoidClaimOutputDto", partName = "VoidClaimOutputDto")
    VoidRetailClaimResponseDto voidRetailClaim(@WebParam(name = "voidRetailClaim", targetNamespace = "http://luxotticaretail.services.com/Adapter/Insurance")VoidRetailClaimRequestDto input);

    @WebMethod (operationName = "DoOnlineCustomerSearch")
    @WebResult(name = "OnlineCustomerResponseDto", partName = "OnlineCustomerResponseDto")
    OnlineCustomerResponseDto doOnlineCustomerSearch(@WebParam(name = "onlineCustomerRequest", targetNamespace = "http://luxotticaretail.services.com/Adapter/Insurance")OnlineCustomerRequestDto input);
}

