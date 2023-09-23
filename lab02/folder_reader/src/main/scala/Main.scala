import java.io.File

object RecursiveTree {

  def listFilesRecursive(directory: File, indent: String = ""): Unit = {
    if (directory.isDirectory) {
      println(indent + directory.getName)
      val files = directory.listFiles
      for (file <- files) {
        if (file.isDirectory) {
          listFilesRecursive(file, indent + "|  ")
        } else {
          println(indent + "|--" + file.getName)
        }
      }
    }
  }

  def main(args: Array[String]): Unit = {
    if (args.length != 1) {
      println("Usage: RecursiveTree <directory>")
      System.exit(1)
    }

    val directoryPath = args(0)
    val rootDirectory = new File(directoryPath)

    if (rootDirectory.exists() && rootDirectory.isDirectory) {
      listFilesRecursive(rootDirectory)
    } else {
      println(s"'$directoryPath' is not a valid directory.")
    }
  }
}
