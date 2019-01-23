package eu.europa.esig.dss.validation.process.bbb.sav.checks;

import java.util.Date;

import eu.europa.esig.dss.jaxb.detailedreport.XmlConstraintsConclusion;
import eu.europa.esig.dss.jaxb.diagnostic.XmlBasicSignature;
import eu.europa.esig.jaxb.policy.CryptographicConstraint;

public class DigestCryptographicCheck<T extends XmlConstraintsConclusion> extends AbstractCryptographicCheck<T> {
	
	String digestAlgorithmName;
	
	public DigestCryptographicCheck(T result, String digestAlgorithmName, Date currentTime, CryptographicConstraint constraint) {
		super(result, currentTime, constraint);
		this.digestAlgorithmName = digestAlgorithmName;
	}

	@Override
	protected boolean process() {
		
		// Check digest algorithm
		if (!digestAlgorithmIsReliable(digestAlgorithmName))
			return false;
		
		// Check digest algorithm expiration date
		if (!digestAlgorithmIsValidOnValidationDate(digestAlgorithmName))
			return false;
		
		return true;
		
	}

}
