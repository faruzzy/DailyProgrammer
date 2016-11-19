// https://www.reddit.com/r/dailyprogrammer/comments/3h9pde/20150817_challenge_228_easy_letters_in/
﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Easy_LettersInAlphabeticalOrder_Link
{
    class Program
    {
        static void Main(string[] args)
        {
            var strings = "billowy biopsy chinos defaced chintz sponged bijoux abhors fiddle begins chimps wronged".Split(' ');
            foreach (var str in strings) 
            {
                if (String.Concat(str.ToCharArray().OrderByDescending(c => c)).Equals(str))
                {
                    Console.WriteLine("REVERSE ORDER");
                }
                else if (String.Concat(str.ToCharArray().OrderBy(c => c)).Equals(str))
                {
                    Console.WriteLine("IN ORDER");
                }
                else
                {
                    Console.WriteLine("NOT IN ORDER");
                }
            }
            Console.ReadLine();
        }
    }
}
