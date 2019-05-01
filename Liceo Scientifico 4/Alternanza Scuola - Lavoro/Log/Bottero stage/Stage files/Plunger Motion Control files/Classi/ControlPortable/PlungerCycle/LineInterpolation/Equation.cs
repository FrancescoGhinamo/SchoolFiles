using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ControlPortable.PlungerCycle.LineInterpolation
{

    /// <summary>
    /// General representation of an equation explicited in y
    /// </summary>
    public abstract class Equation
    {
        /// <summary>
        /// Calculus of the value of the equation from the given x value
        /// </summary>
        /// <param name="x">Independent varable (x)</param>
        /// <returns>Value of dependent variable (y)</returns>
        public abstract double calcFX(double x);

        /// <summary>
        /// Calculus of x value from given y
        /// </summary>
        /// <param name="y">y value from which calculate the x</param>
        /// <returns>Calculated x</returns>
        public abstract double getInverse(double y);
    }
}
