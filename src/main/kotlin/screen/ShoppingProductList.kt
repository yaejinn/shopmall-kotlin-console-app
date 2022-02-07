package screen

import LINE_DIVIDER
import data.CartItems
import data.Product
import extensions.getNotEmptyInt
import extensions.getNotEmptyString

class ShoppingProductList(private val selectedCategory: String):Screen(){
    private val products = arrayOf(
        Product("패션","겨울 패딩"),
        Product("패션","겨울 바지"),
        Product("전자기기", "핸드폰"),
        Product("전자기기", "블루투스 이어폰"),
        Product("전자기기", "노트북"),
        Product("반려동물용품","건식 사료"),
        Product("반려동물용품","습식 사료"),
        Product("반려동물용품","치약"),
        Product("반려동물용품","간식"),
    )

    private val categories: Map<String,List<Product>> =
        products.groupBy { products ->
            products.categoryLabel
        }

    /*
     * 사용자가 입력한 카테고리 정보를 받아 해당 카테고리의 상품을 출력
     */
    fun showProducts() {
        //스택에 저장
        ScreenStack.push(this)
        // 지정된 카테고리의 상품 목록을 가져온다.
        val categoryProducts = categories[selectedCategory]

        if (!categoryProducts.isNullOrEmpty()){
            println("""
                $LINE_DIVIDER
                    선택하신 [$selectedCategory] 카테고리 상품입니다.
            """.trimIndent())
            /*
            val productSize = categoryProducts.size
            for (index in 0 until productSize){
                println("${index}.${categoryProducts[index].name}")
            }
            */
            categoryProducts.forEachIndexed {
                    index, product -> println("${index}.${product.name}")
            }
            //장바구니에 담을 상품 선택
            showCartOption(categoryProducts)
        }else{
            showEmptyProductMessage(selectedCategory)
        }
    }

    private fun showCartOption(categoryProducts: List<Product>) {
        println("""
            $LINE_DIVIDER
            장바구니에 담을 상품 번호를 선택해 주세요
        """.trimIndent())

        //상품 번호 입력 수행
        val selectedIndex = readLine().getNotEmptyInt()
        categoryProducts.getOrNull(selectedIndex)?.let{
            product -> CartItems.addProduct(product)
            println("=>장바구니로 이동하시려면 #을, 계속 쇼핑하시려면 *를 입력해 주세요:")
            val answer = readLine().getNotEmptyString()
            if (answer == "#") {
                val shoppingCart = ShoppingCart()
                shoppingCart.showCartItems()
            } else if (answer == "*") {
                showProducts()
            } else {
                println("잘못된 입력입니다. 다시 입력해 주세요.")
                showProducts()
            }
        } ?: kotlin.run{
            println("$selectedIndex 은 목록에 없는 상품 번호입니다. 다시 입력해 주세요!")
            showProducts()
        }
    }

    private fun showEmptyProductMessage(selectedCategory: String) {
        println("[$selectedCategory] 카테고리 상품이 등록되기 전입니다.")
    }
}