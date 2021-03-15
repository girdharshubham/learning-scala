trait ResettableDatabase {
  def reset(): Unit
}

trait CloneableDatabase {
  def mirror(): Unit
}

class CassandraMigration extends ResettableDatabase with CloneableDatabase {
  override def reset(): Unit = println("I reset")

  override def mirror(): Unit = println("I mirror")
}

object CassandraMigration {
  def apply(): CassandraMigration = new CassandraMigration()
}

def apply(obj: ResettableDatabase with CloneableDatabase): Unit = println("I apply")

apply(CassandraMigration())