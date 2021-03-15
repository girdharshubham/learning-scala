package edu.self

trait ResettableDatabase {
  def reset(): Unit
}

trait CloneableDatabase {
  def mirror(): Unit
}
