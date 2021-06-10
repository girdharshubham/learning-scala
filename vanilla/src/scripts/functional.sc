val curriedFunc: Int => Int => Int = (x: Int) => (y: Int) => x + y

def curriedMeth(x: Int)(y: Int): Int = x + y

curriedFunc(1)(2)
curriedMeth(1)(2)

//val variadicFunction = (x: Int*) => x.map(_*2)

def variadicMethod(x: Int*) = x.map(_*2)
//variadicFunction(1)
variadicMethod(1,2,3,4,5,6,7)