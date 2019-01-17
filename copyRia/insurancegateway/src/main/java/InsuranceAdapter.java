package com.luxottica.ria.services.ws;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

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
import com.luxottica.ria.services.routingengine.RoutingEngine;
/***
 *
 * @author Antonio Magnocavallo
 *
 */
@Service
@WebService(name = "InsuranceAdapter", targetNamespace = "http://luxotticaretail.services.com/Adapter/Insurance", endpointInterface="com.luxottica.ria.services.ws.InsuranceAdapterInterface")
public class InsuranceAdapter extends SpringBeanAutowiringSupport implements InsuranceAdapterInterface{

    @Autowired
    private RoutingEngine routingEngine;

    @Override
    public GetNewTokenResponseDto getNewToken(GetNewTokenRequestDto input) {
        return routingEngine.getNewToken(input);
    }

    @Override
    public DoctorDataResponseDto doctorData(DoctorDataRequestDto input) {
        return routingEngine.doctorData(input);
    }
    @Override
    public FindRetailMembersResponseDto findMembers(FindRetailMembersRequestDto input){
        return routingEngine.findMembers(input);
    }

    @Override
    public GetRetailMemberResponseDto getMember(GetRetailMemberRequestDto input) {
        return routingEngine.getMember(input);
    }

    @Override
    public GetRetailEligibilityResponseDto getMemberEligibility(GetRetailEligibilityRequestDto input) {
        return routingEngine.getMemberEligibility(input);
    }

    @Override
    public POSSubmitClaimResponseDto posSubmitClaim(POSSubmitClaimRequestDto input) {
        return routingEngine.posSubmitClaim(input);
    }

    @Override
    public GetRetailPlanResponseDto getPlan(GetRetailPlanRequestDto input) {
        return routingEngine.getPlan(input);
    }

    @Override
    public GetRetailBenefitPricingResponseDto priceClaim(GetRetailBenefitPricingRequestDto input) {
        return routingEngine.priceClaim(input);
    }

    @Override
    public GetBenefitLevelsResponseDto getBenefitLevels(GetBenefitLevelsRequestDto input) {
        return routingEngine.getBenefitLevels(input);
    }

    @Override
    public FindRetailPlansResponseDto findRetailPlans(FindRetailPlansRequestDto input) {
        return routingEngine.findRetailPlans(input);
    }

    @Override
    public VoidRetailClaimResponseDto voidRetailClaim(VoidRetailClaimRequestDto input) {
        return routingEngine.voidRetailClaim(input);
    }

    @Override
    public GetBenefitsNarrativeResponseDto getBenefitsNarrative(GetBenefitsNarrativeRequestDto input) {
        return routingEngine.getMemberBenefits(input);
    }

    @Override
    public GetTenderStatusResponseDto getTenderStatus(GetTenderStatusRequestDto input) {
        return routingEngine.getTenderStatus(input);
    }

    @Override
    public OnlineCustomerResponseDto doOnlineCustomerSearch(OnlineCustomerRequestDto input) {
        return routingEngine.doOnlineCustomerSearch(input);
    }

    public void setRoutingEngine(RoutingEngine routingEngine) {
        this.routingEngine = routingEngine;
    }


}

