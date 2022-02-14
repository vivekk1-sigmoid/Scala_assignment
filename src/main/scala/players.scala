class players(var year: Int, var playerName: String, var country: String, var matches: Int, var runs: Int, var wickets: Int) {}

object players {
  def Desc[T: Ordering] = implicitly[Ordering[T]].reverse;

  // Insert Method to bind all the information
  def push_back(year: Int, playerName: String, country: String, matches: Int, runs: Int, wickets: Int): players = {
    var playerInfo = new players(year, playerName, country, matches, runs, wickets);
    return playerInfo;
  }

  def main(args: Array[String]): Unit = {

    // Dummy Values
    var playerList = List(push_back(2021, "Sam", "India", 23, 2300, 3))
    playerList = playerList :+ push_back(2021, "Ram", "India", 23, 300, 30)
    playerList = playerList :+ push_back(2021, "Mano", "India", 23, 300, 13)
    playerList = playerList :+ push_back(2014, "Vivek", "India", 24, 3220, 7)
    playerList = playerList :+ push_back(2018, "Mohan", "Australia", 25, 2100, 57)
    playerList = playerList :+ push_back(2019, "Sachin", "India", 24, 22300, 577)
    playerList = playerList :+ push_back(2021, "Anderson", "India", 22, 3000, 3)
    playerList = playerList :+ push_back(2019, "Rahul", "New Zealand", 25, 2300, 14)

    //Question:1 //
    println("Q1: Player with the best highest run scored");
    var playerWithHighestRun = playerList.sortBy(_.runs).reverse
    println(playerWithHighestRun(0).playerName)

    println()
    //Question: 2//
    println("Q2: Top 5 players by run scored")
    //    println(playerWithHighestRun.take(5))
    for (player <- playerWithHighestRun.take(5)) {
      println(player.playerName)
    }

    println()
    //Question: 3//
    println("Q3: Top 5 players by wicket taken")
    var playerWithHighestWickets = playerList.sortBy(x => x.wickets).reverse
    //    println(playerWithHighestWickets.take(5))
    for (player <- playerWithHighestWickets.take(5)) {
      println(player.playerName)
    }

    println()
    //Question: 4//
    println("Q4: Rank players with overall performance give weight 5x to wicket taken and (5/100)x to run scored")
    playerList = playerList.sortBy(x => x.wickets * 5).sortBy(x => x.runs * 0.05).reverse
    var count: Int = 1
    for (player <- playerList) {
      println(s"Rank $count : " + player.playerName)
      count += 1;
    }
  }
}
