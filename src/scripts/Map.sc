val map = Map(
  "shubham" -> "girdhar"
)

map isDefinedAt "shubham"
map.exists(_._1 == "shubham")
map contains "shubham"