val someOption: Option[String] = Some("Here's a random string")

val no: Option[String] = None


no
  .map(_ * 2)

someOption
  .map(_ * 2)

someOption
  .filter(_ != "Meh")

someOption
  .fold("MEH")(identity)