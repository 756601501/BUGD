package test;

/**
 * @purpose ���󴴽�����
 * @author bugd
 * 
 */
public class ReasonerFactory {

	public static IReasoner createFamilyReasoner() {
		IReasoner familyReasoner = new ReasonerImpl();
		return familyReasoner;
	}
}
