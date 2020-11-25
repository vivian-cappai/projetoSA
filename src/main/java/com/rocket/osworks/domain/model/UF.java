package com.rocket.osworks.domain.model;

public enum UF {
	RO("RO","Rondônia"),
	AC("AC","Acre"),
	AM("AM","Amazonas"),
	RR("RR","Roraima"),
	PA("PA","Pará"),
	AP("AP","Amapá"),
	TO("TO","Tocantins"),
	MA("MA","Maranhão"),
	PI("PI","Piauí"),
	CE("CE","Ceará"),
	RN("RN","Rio Grande do Norte"),
	PB("PB","Paraíba"),
	PE("PE","Pernambuco"),
	AL("AL","Alagoas"),
	SE("SE","Sergipe"),
	BA("BA","Bahia"),
	MG("MG","Minas Gerais"),
	ES("ES","Espírito Santo"),
	RJ("RJ","Rio de Janeiro"),
	SP("SP","São Paulo"),
	PR("PR","Paraná"),
	SC("SC","Santa Catarina"),
	RS("RS","Rio Grande do Sul"),
	MS("MS","Mato Grosso do Sul"),
	MT("MT","Mato Grosso"),
	GO("GO","Goiás"),
	DF("DF","Distrito Federal");
	
	private String sigla;
	private String descrição;
	
	UF(String sigla,String descrição){
		this.sigla = sigla;
		this.descrição = descrição;
	}

	public String getSigla() {
		return sigla;
	}

	public String getDescrição() {
		return descrição;
	}
}
