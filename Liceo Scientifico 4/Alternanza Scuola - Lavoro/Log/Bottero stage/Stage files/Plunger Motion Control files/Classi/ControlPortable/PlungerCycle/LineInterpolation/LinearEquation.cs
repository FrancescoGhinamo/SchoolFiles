using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ControlPortable.PlungerCycle.LineInterpolation
{
    /// <summary>
    /// Representation of the equation of a line of type y = a + bx
    /// </summary>
    public class LinearEquation : Equation
    {
        #region Fields
        /// <summary>
        /// Nown member of the equation
        /// </summary>
        private double aC { get; set; }
        /// <summary>
        /// x coefficent of the equation
        /// </summary>
        private double bC { get; set; }

        #endregion Fields;

        #region Contrutctor

        /// <summary>
        /// Constructor of the linear equation
        /// </summary>
        /// <param name="a">Known member</param>
        /// <param name="b">Coefficent of x</param>
        public LinearEquation(double a, double b)
        {
            aC = a;
            bC = b;
        }

        #endregion Constructor

        #region InheritedMethods

        /// <summary>
        /// Calculus of the value of the equation from the given x value
        /// </summary>
        /// <param name="x">Independent varable (x)</param>
        /// <returns>Value of dependent variable (y)</returns>
        public override double calcFX(double x) => aC + bC * x;

        /// <summary>
        /// Calculus of x value from given y
        /// </summary>
        /// <param name="y">y value from which calculate the x</param>
        /// <returns>Calculated x</returns>
        public override double getInverse(double y) => (y - aC) / bC;
        
        #endregion InheritedMethods


    }
}
