package screen

class ShoppingHome {
        /*
         *쇼핑몰 프로그램의 시작 위치
         */
        fun start(){
            showWelcomeMessage()

            showCategories()
        }

    /*
     * 인사말 출력
     */
    fun showWelcomeMessage() {
        println("안녕하세요, Shopmall 에 오신 것을 환영합니다!")
        println("쇼핑을 계속 하시려면 이름을 입력해 주세요:")

        val name = readLine() //화면에서 사용자 입력받기

        println(
            """
            감사합니다. 반갑습니다. $name 님
            원하시는 카테고리를 입력해주세요.
            ***===================================***
        """.trimIndent()
        )
    }

    private fun showCategories(){
        val shoppingCategory = ShoppingCategory()

        shoppingCategory.showCategories()
    }
}