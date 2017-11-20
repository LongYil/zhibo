package cn.lxy.vo;

/**
 * <p>Title:AnalysedExam</p>
 * <p>Description:解析后的试题 </p>
 * @author 李银龙
 *		2017年11月20日
 *		下午6:48:32
 */
public class AnalysedExam {
	private int id;
	private String question;
	private String result;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	
}
