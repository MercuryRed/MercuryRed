using System;
using System.IO;

namespace MoveImports
{
    class Program
    {
        const string FROM = @"c:\12\Android\MercuryRedDevNull\";
        const string TO = @"c:\12\Android\MercuryRedDest\";

        // todo ... call with a tool on *.java files recursively

        static void Main(string[] args)
        {
            string[] filenames = Directory.GetFiles(@"c:\12\Android\MercuryRed\", "*.java", SearchOption.AllDirectories);

            foreach (string filename in filenames)
            {
                //Console.WriteLine(filename);
                ProcessJavaFile(filename);
            }
        }

        static void ProcessJavaFile(string filename)
        {
            string code = File.ReadAllText(filename);

            char[] newCode = new char[code.Length * 2 + 100];
            int len = 0;

            String line = "";
            foreach (char ch in code)
            {
                if (ch == '\r' || ch == '\n')
                {
                    line = rebuildLine(line);
                    foreach (char x in line)
                    {
                        newCode[len++] = x;
                    }
                    line = "";
                    newCode[len++] = ch;
                } else
                {
                    line = line + ch;
                }
            }

            // flush last line
            foreach (char x in line)
            {
                newCode[len++] = x;
            }

            // rewrite file - todo
            // File.WriteAllText(filename, new string(newCode, 0, len));
        }

        static string[] packages = new string[]
        {
            "java.awt",
            "javax.swing",
            "javax.imageio",
        };

        static string[] dests = new string[]
        {
            "com.mercuryred.ui",
            "com.mercuryred.uiplus",
            "com.mercuryred.imageio",
        };


        // rebuilds line, also copied the target file from source folder to dest folder
        private static string rebuildLine(string line)
        {
            if (line.Length == 0) return line;
            if (!line.StartsWith("import ")) return line;

            string importFullName = line.Substring("import ".Length);
            importFullName = importFullName.Trim(' ');
            importFullName = importFullName.Trim(';');
            importFullName = importFullName.Trim(' ');

            // special case, importing static constants, will handle manually
            if (importFullName.EndsWith("*")) return line;

            int i = -1;
            foreach (string package in packages)
            {
                i++;
                string dest = dests[i];

                if (importFullName.StartsWith(package + "."))
                {
                    string subImport = importFullName.Substring(package.Length + 1);
                    int index = subImport.LastIndexOf(".");
                    string subPackage = index > 0 ? subImport.Substring(0, index) : "";

                    /// todo .. subpackage structure maintain ... 
                    // remove package 
                    string[] parts = importFullName.Split('.');
                    string className = parts[parts.Length - 1];

                    string from = FROM + importFullName.Replace(".", "\\") + ".java";
                    string to = TO + dest.Replace(".", "\\") + "\\" + subImport.Replace(".", "\\") + ".java";

                    string dir = TO + dest.Replace(".", "\\") + "\\" + subPackage.Replace(".", "\\");

                    System.IO.Directory.CreateDirectory(dir);

                    if (!File.Exists(from))
                    {
                        Console.WriteLine("MISSING " + importFullName);
                        // ERROR
                        return line;
                    }

                    System.IO.File.Copy(from, to, true);

                    return line; // todo modify
                }
            }



            return line;
        }
    }
}
