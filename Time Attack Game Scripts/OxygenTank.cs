using System.Collections;
using System.Collections.Generic;
using UnityEngine;
/// <summary>
/// Author: Mason Burns
/// Date: 11/29/2022
/// 
/// OxygenTank script to control the oxygen tank and add time to the timer after being picked up
/// </summary>
public class OxygenTank : MonoBehaviour
{
    //The amount of time to be added to the timer
    private float amount = 15f;

    private void OnTriggerEnter2D(Collider2D collision)
    {
        //Getting access to the Timer script
        Timer tm = GameObject.FindObjectOfType<Timer>();
        if (collision.tag == "Player")
        {
            //destroying the oxygen tank after it's picked up
            Destroy(gameObject);
            //adding time to the timer
            tm.AddTime(amount);

        }
    }
}
