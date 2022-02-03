package screen

class ShoppingCategory {
    fun showCategories() {
        /*
         *(1)상품 카테고리 표시
         *(2)사용자 입력 받기
         *(3)사용자가 잘못된 값 입력 처리
         */
        val categories = arrayOf("패션", "전자기기", "반려동물용품")
        for (category in categories) {
            println(category)
        }
        println("==> 장바구니로 이동하시려면 '#'을 입력해 주세요.")

        //카테고리 입력 받기
        var selectedCategory = readLine()

        //사용자가 올바른 입력을 할때까지 반복처리
        while (selectedCategory.isNullOrBlank()) {
            println("값을 입력해 주세요!")
            selectedCategory = readLine()
        }
        if (selectedCategory == "#") {
            //TODO(1)장바구니로 이동
        } else {
            if(categories.contains(selectedCategory)){
                //카톄고리 상품 목록 보여주기
                val shoppingProductList  = ShoppingProductList()
                shoppingProductList.showProducts(selectedCategory)
            }else {
                showErrorMessage(selectedCategory)
            }
        }
    }

    private fun showErrorMessage(selectedCategory: String?) {
        println("[$selectedCategory]:존재하지 않는 카테고리입니다. 다시 입력해 주세요!")
        showCategories()
    }
}