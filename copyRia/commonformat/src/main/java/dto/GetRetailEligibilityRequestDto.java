package com.luxottica.ria.commonformat.dto.eligibility;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.luxottica.ria.commonformat.dto.GenericSessionInputDTO;
import com.luxottica.ria.commonformat.dto.Member;

/**
 * <p>
 * Java Class for GetRetailEligibilityRequestDto complex type.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetRetailEligibilityRequestDto", propOrder = {
        "benefitLevelId",
        "eligibilityCheck",
        "POSSystemName"
})
public class GetRetailEligibilityRequestDto extends GenericSessionInputDTO {

    @XmlTransient
    protected String planId;
    @XmlTransient
    protected Member memberData;
    @XmlTransient
    protected String providerClass;
    @XmlElement(name = "benefitLevelId")
    protected String benefitLevelId;
    @XmlTransient
    protected String siteNumber;
    @XmlElement(name = "POSSystemName")
    protected String POSSystemName;
    @XmlElement(name = "eligibilityCheck")
    protected Boolean eligibilityCheck;

    @Override
    public String toString() {
        return "GetRetailEligibilityRequestDto [benefitLevelId="
                + benefitLevelId + ", siteNumber=" + siteNumber
                + ", POSSystemName=" + POSSystemName + ", eligibilityCheck="
                + eligibilityCheck + "]";
    }

    /**
     * Retrieves the value of the property memberId.
     */
    public String getMemberId() {
        return getMemberData().getMemberId();
    }

    /**
     * Retrieves the value of the property siteNumber.
     */
    public String getSiteNumber() {
        return siteNumber;
    }

    /**
     * Retrieves the value of the property systemName.
     */
    public String getPOSSystemName() {
        return POSSystemName;
    }

    /**
     * Set the property value memberId.
     */
    public void setMemberId(String memberId) {
        getMemberData().setMemberId(memberId);
    }

    /**
     * Set the property value siteNumber.
     */
    public void setSiteNumber(String siteNumber) {
        this.siteNumber = siteNumber;
    }

    /**
     * Set the property value systemName.
     */
    public void setPOSSystemName(String POSSystemName) {
        this.POSSystemName = POSSystemName;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getBenefitLevelId() {
        return benefitLevelId;
    }

    public void setBenefitLevelId(String benefitLevelId) {
        this.benefitLevelId = benefitLevelId;
    }

    public String getProviderClass() {
        return providerClass;
    }

    public void setProviderClass(String providerClass) {
        this.providerClass = providerClass;
    }

    public Boolean getEligibilityCheck() {
        return eligibilityCheck;
    }

    public void setEligibilityCheck(Boolean eligibilityCheck) {
        this.eligibilityCheck = eligibilityCheck;
    }

    public Member getMemberData() {
        if (memberData == null) {
            memberData = new Member();
        }
        return memberData;
    }

    public void setMemberData(Member memberData) {
        this.memberData = memberData;
    }
}

