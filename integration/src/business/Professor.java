/**
 * 
 * This holds the professor profile information
 * @author: Pavan Kumar Sunder and Susan Chun Xu
 * 
 * 
 */

package business;

public class Professor {
	private String profId;
	private String profName;
	private String profEmail;
	private String profPhone;
	private String profScore;
	private String profSkill;
	private String profCertificate;
	private String profProfession;

	public Professor() {
	}

	public Professor(String profId, String profName, String profEmail,
			String profPhone, String profScore, String profSkill,
			String profCertificate, String profProfession) {
		super();
		this.profId = profId;
		this.profName = profName;
		this.profEmail = profEmail;
		this.profPhone = profPhone;
		this.profScore = profScore;
		this.profSkill = profSkill;
		this.profCertificate = profCertificate;
		this.profProfession = profProfession;
	}

	public String getProfId() {
		return profId;
	}

	public void setProfId(String profId) {
		this.profId = profId;
	}

	public String getProfName() {
		return profName;
	}

	public void setProfName(String profName) {
		this.profName = profName;
	}

	public String getProfEmail() {
		return profEmail;
	}

	public void setProfEmail(String profEmail) {
		this.profEmail = profEmail;
	}

	public String getProfPhone() {
		return profPhone;
	}

	public void setProfPhone(String profPhone) {
		this.profPhone = profPhone;
	}

	public String getProfScore() {
		return profScore;
	}

	public void setProfScore(String profScore) {
		this.profScore = profScore;
	}

	public String getProfSkill() {
		return profSkill;
	}

	public void setProfSkill(String profSkill) {
		this.profSkill = profSkill;
	}

	public String getProfCertificate() {
		return profCertificate;
	}

	public void setProfCertificate(String profCertificate) {
		this.profCertificate = profCertificate;
	}

	public String getProfProfession() {
		return profProfession;
	}

	public void setProfProfession(String profProfession) {
		this.profProfession = profProfession;
	}
}
