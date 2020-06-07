// ** member 오류 확인사항
// ID : 길이(4이상), 영문자,숫자 로만 구성
// password : 길이(4이상), 숫자와 특수문자는 반드시 1개 이상 포함할것
// Name : 길이(2이상), 영문 또는 한글로 만 입력
// Level : select 를 이용 (X)
// BirthDay : 입력 여부 확인
// Point : 정수의 범위
// Weight: 구간 (30 ~ 200)
// 추천인 : 필수 사항이 아님 (X)

// ** 작성 규칙
// => JavaScript function 으로 정의 하고 
//    결과를 true or false 로 return

function idCheck() {
	var id = $('#id').val() ;
	if (id.length<4) {
		  $('#iMessage').html('ID 는 4 글자 이상 입력하세요 ~~');		
		  $('#id').focus();
		  return false;
	 	}else if (id.replace(/[a-z.0-9]/gi,'').length>0) {
	 		 $('#iMessage').html('ID 는 영문자 와 숫자 로만 입력하세요 ~~');
	 		$('#id').focus();
	 		 return false;
	 	}else {
	 		$('#iMessage').html('');
	 		return true;
	 	}
}; // idCheck() 


