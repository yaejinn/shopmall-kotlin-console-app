package data
//상품 데이터를 저장
//프로젝트 전역에서 참조하는 데이터 유지
object CartItems {
    private val mutableProducts = mutableMapOf<Product, Int>()
    val products:Map<Product, Int> = mutableProducts

    fun addProduct(product: Product){
        mutableProducts[product]?.let{
            mutableProducts[product] = it +1
        }   ?:kotlin.run{
            mutableProducts[product] = 1
        }
    }
}