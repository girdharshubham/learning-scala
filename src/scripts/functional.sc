val curriedFunc: Int => Int => Int = (x: Int) => (y: Int) => x + y

def curriedMeth(x: Int)(y: Int): Int = x + y

curriedFunc(1)(2)
curriedMeth(1)(2)
