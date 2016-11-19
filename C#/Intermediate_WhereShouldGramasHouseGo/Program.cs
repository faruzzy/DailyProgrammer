// https://www.reddit.com/r/dailyprogrammer/comments/3l61vx/20150916_challenge_232_intermediate_where_should/
﻿using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;

namespace Intermediate_WhereShouldGramasHouseGo
{
    class Program
    {
        static void Main(string[] args)
        {
            decimal minDistance = 0;
            var list = new List<Point>();
            var lines = File.ReadAllLines("input.txt").Skip(1).ToArray();
            lines = cleanLines(lines);

            for (int i = 0; i < lines.Length; i++)
            {
                var pt1 = ExtractPointFromString(lines[i]);
                var pt2 = new Point();
                for (int j = i + 1; j < lines.Length; j++)
                {
                    var success = false;
                    pt2 = ExtractPointFromString(lines[j]);
                    if (minDistance == 0)
                    {
                        minDistance = Point.Distance(pt1, pt2);
                    }
                    else
                    {
                        var tempDistance = Point.Distance(pt1, pt2);
                        if (tempDistance < minDistance)
                        {
                            minDistance = tempDistance;
                            success = true;
                        }
                    }

                    if (success)
                    {
                        if (list.Count() == 0)
                        {
                            list.Add(pt1);
                            list.Add(pt2);
                        }
                        else
                        {
                            list.Clear();
                            list.Add(pt1);
                            list.Add(pt2);
                        }
                        success = false;
                    }
                }
            }

            var s = String.Format("({0}, {1}) ({2}, {3})", list[0].X, list[0].Y, list[1].X, list[1].Y);
            Console.WriteLine(s);
            Console.ReadLine();
        }

        /// <summary>
        /// Replace all elements in the array with the orginal content minus the parantheses
        /// </summary>
        /// <param name="lines"></param>
        /// <returns></returns>
        private static string[] cleanLines(string[] lines)
        {
            for (int i = 0; i < lines.Length; i++)
                lines[i] = lines[i].Substring(1, lines[i].Length - 2);
            return lines;
        }

        private static Point ExtractPointFromString(string str)
        {
            var temp = str.Split(',');                 
            return new Point(decimal.Parse(temp[0]), decimal.Parse(temp[1]));
        }

    }
    
    class Point
    {
        /// <summary>
        /// The X Coordinate of the Point
        /// </summary>
        public decimal X { get; private set; }

        /// <summary>
        /// The Y Coordinate of the Point
        /// </summary>
        public decimal Y { get; private set; }

        public Point()
        {
            X = 0;
            Y = 0;
        }

        public Point(decimal x, decimal y)
        {
            X = x;
            Y = y;
        }

        /// <summary>
        /// Determine disance between two points
        /// </summary>
        /// <param name="pt1">First Point</param>
        /// <param name="pt2">Second Point</param>
        /// <returns>The distance between the two Points</returns>
        public static decimal Distance(Point pt1, Point pt2)
        {
            return (decimal)Math.Sqrt(Math.Pow((double)(pt1.X - pt1.Y), 2) + Math.Pow((double)(pt2.X - pt2.Y), 2));
        }
    }
}
