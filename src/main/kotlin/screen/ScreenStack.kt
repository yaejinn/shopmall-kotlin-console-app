package screen
/*
 * 프로그램에서 실행한 화면내용을 스택에 관리
 */
object ScreenStack {
    private val screenStack = mutableListOf<Screen>()   //실행한 화면 저장 변수

    //방금 실행한 화면을 스택에 저장
    fun push(screen: Screen){
        screenStack.add(screen)
    }

    //화면 스택에서 가장 위의 화면을 꺼낸다.
    fun pop(){
        screenStack.removeLastOrNull()
    }

    //스택에서 꺼내지 않고 내용만 확인
    fun peak():Screen? {
        return screenStack.lastOrNull()
    }
}

sealed class Screen