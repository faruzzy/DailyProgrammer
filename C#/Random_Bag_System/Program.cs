// https://www.reddit.com/r/dailyprogrammer/comments/3ofsyb/20151012_challenge_236_easy_random_bag_system/
﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Randdom_Bag_System
{
    class Program
    {
        static void Main(string[] args)
        {
            var dictionary = new Dictionary<string, bool>()
            {
                {"O", false},
                {"I", false},
                {"S", false},
                {"Z", false},
                {"L", false},
                {"J", false},
                {"T", false}
            };

            var sb = new StringBuilder();
            int c = 0;
            for (int i = 0; i < 50; i++)
            {
                int random;
                do
                {
                    random = new Random().Next(0, 7);
                } while (dictionary.ElementAt(random).Value);

                string k = dictionary.ElementAt(random).Key;
                sb.Append(k);
                dictionary[k] = true;

                if (c == 6)
                {
                    foreach (var kk in dictionary.Keys.ToList()) 
                    {
                        dictionary[kk] = false; 
                    }
                    c = 0;
                }
                c++;
            }

            Console.WriteLine(sb.ToString());
            Console.ReadLine();
        }
    }
}
