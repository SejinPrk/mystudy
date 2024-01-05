package bitcamp.myapp.vo;

// caller: CSV 문자열을 받아서 파일에 저장하는 측
// callee: 규칙에 따라 호출당하는 도메인 객체(domain) = 값 객체(Value Object; VO) = 데이터 전송 객체(DTO)
public interface CsvString {
  String toCsvString();


}
