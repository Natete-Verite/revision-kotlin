fun main(){
//    var myAccount = CurrentAccount("bk0004356","Verite",1000000.0)
//        myAccount.deposit(500000.0)
//        myAccount.withdraw(100000.0)
//        myAccount.details()

    var mySavingsAccountAccount = SavingsAccount("bk0004356","Natete",
        1000000.0,1)
        mySavingsAccountAccount.withdraw(100000.0)
        mySavingsAccountAccount.withdraw(100000.0)
        mySavingsAccountAccount.withdraw(100000.0)
        mySavingsAccountAccount.withdraw(100000.0)
        mySavingsAccountAccount.withdraw(100000.0)
        println(mySavingsAccountAccount.withdrawals)

    var shopping = Product("Teepee",1.20,10.0,"Hygiene")
    var shoppingOne = Product("Apple",0.20,5.0,"Groceries")
    var shoppingTwo = Product("Pencil",0.10,2.0,"Other")
    var a = listOf(shopping,shoppingOne,shoppingTwo)
    newProduct(shopping)
    newProduct(shoppingOne)
    newProduct(shoppingTwo)

    println(charAtEvenIndices("Verite"))




}
//Create a classCurrentAccount with the following attributes:account number, account name, balance.
// It has the following functions:
//a.deposit(amount: Double) - Increments the balance by the amount deposited
//b.withdraw(amount: Double) - Decrements the balance by the amount withdrawn
//c.details() - Prints out the account number and balance and name in this format: “Account number x
// with balance y is operated by z”
open class CurrentAccount(var accountNumber:String, var accountName:String, var balance:Double){
    fun deposit(amount:Double){
        balance+=amount
        println("Your new balance is $balance")
    }
    open fun withdraw(amount:Double){
        balance-=amount
        println("Your new balance is $balance")
    }
    fun details(){
        println("Account number $accountNumber with balance $balance is operated by $accountName" )
    }
}
//Create another class SavingsAccount. It has the same functions and attributes as the current account except
// for one attribute, withdrawals: Int. Withdrawals is a counter variable that is used to keep track of how
// many withdrawals have been made from the account in a year. The only other difference is that the
// savings account withdraw() method first checks if the number of withdrawals is less than 4 for it to
// allow one to withdraw money from the account. It also increments the withdrawals attribute after a
// successful withdrawal
class SavingsAccount(accountNumber:String, accountName:String, balance:Double, var withdrawals:Int):
    CurrentAccount(accountNumber,accountName,balance){
    override fun withdraw(amount: Double) {
        if (withdrawals<4){
            balance-=amount
            println(balance)
            withdrawals++
        }
        else{
            println("Withdraw not successful")
        }
    }
}
//A product is represented by a data class with these attributes: name, weight,
// price, category. Category can either be groceries, hygiene or other. Write a
// function that takes in a product and uses a when statement to assign each
// product to a list based on its category.
data class Product(var name:String, var weight:Double, var price:Double,
                   var category:String)
fun newProduct(prod:Product){
    var groceries= mutableListOf<Product>()
    var hygiene= mutableListOf<Product>()
    var others= mutableListOf<Product>()
    when(prod.category){
        "groceries"-> groceries.add(prod)
        "hygiene"-> hygiene.add(prod)
        else -> others.add(prod)
    }
    println(groceries)
    println(hygiene)
    println(others)

}
//Write a function that given a string returns a string composed of only the characters in even indices.
// For example given “banana” it will return “bnn”.
fun charAtEvenIndices(word:String):String{
    var evenIndicesChar = ""
    word.forEachIndexed { index, c ->
        if (index%2==0){
            evenIndicesChar+=c
        }
    }
    return evenIndicesChar
}