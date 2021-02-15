val tagString = "SomeTag@!#!@#$%^&*()P"
tagString.toLowerCase

object TriggerTypes extends Enumeration {
  type TriggerType = Value
  val ReferenceOnly, MilOn, ServerRequest, OncePerTrip = Value
}
val referenceOnly = TriggerTypes.ReferenceOnly

1 match {
  case 2 | 3 => println("meh!")
  case 1 | 4 => println("double meh!")
}

for {
  char <- ('a' to 'z')
} yield (char, 0)