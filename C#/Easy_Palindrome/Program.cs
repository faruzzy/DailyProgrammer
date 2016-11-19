// https://www.reddit.com/r/dailyprogrammer/comments/3kx6oh/20150914_challenge_232_easy_palindromes/
using System;
using System.IO;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;

namespace Easy_Palindrome
{
    class Program
    {
        static void Main(string[] args)
        {
            var fileName = "input1.txt";
            var text = File.ReadAllText(fileName);
            Check(text);
            Console.ReadLine();
        }

        private static bool IsPalindrome(string str)
        {
            var s = Regex.Replace(str, @"[^A-Za-z]", "").ToLower();
            for (int i = 0; i < s.Length / 2; i++)
                if (!s[i].Equals(s[s.Length - i - 1])) return false;
            return true;
        }

        private static void Check(string str)
        {
            if (IsPalindrome(str))
                Console.WriteLine("Is Palindrome");
            else
                Console.WriteLine("Is Not a Palindrome");
        }
    }
}
