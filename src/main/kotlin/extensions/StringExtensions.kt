package extensions
/*
 * 사용자 입력값 처리 클래스
 * String의 확장함수 정의
 */
//카테고리명 입력시
fun String?.getNotEmptyString():String {
    var input = this //this는 입력된 Nullable String
    while(input.isNullOrBlank()){//입력값이 null 혹은 공백이면 잘못된 입력
        println("값을 입력해 주세요")
        input = readLine()
    }
    return input.trim() //입력값의 앞뒤 공백 제거
}
//상품 번호 입력시, int 타입으로 변환 가능 여부확인
fun String?.getNotEmptyInt(): Int{
    var input = this?.trim() //앞뒤 공백없이 값만 input에 저장
    while(input.isNullOrEmpty() || input.toIntOrNull() == null){
        println("값을 입력해 주세요:")
        input = readLine()
    }
    return input.toInt()
}
