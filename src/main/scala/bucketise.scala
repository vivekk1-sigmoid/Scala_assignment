object bucketise {
  def truncateAt(x: Double, p: Int): Double = {
    // To Truncate the value
    val s = math.pow(10, p)
    (x * s).toInt / s
  }

  def bucket(num: Double): (Double, String, Double) = {
    // Used Mathematics to find the bucket in the range
    var initials: Double = (num / 0.05).floor * 0.05;
    //var finals: Double = (num / 0.05).floor * 0.05 + 0.049;
    var finals: Double = initials + 0.049;
    return (truncateAt(initials, 3),"-", truncateAt(finals, 3))
  }

  def main(args: Array[String]): Unit = {
    var numbers: Array[Double] = Array(12.05, 12.03, 10.33, 11.45, 13.5)
    for (number <- numbers) {
      print(s"The bucket value of $number is found between: ")
      println(bucket(number))
    }
  }
}
