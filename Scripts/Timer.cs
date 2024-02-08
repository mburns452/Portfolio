using System.Collections;
using System.Collections.Generic;
using TMPro;
using UnityEngine;
/// <summary>
/// Author: Mason Burns
/// Date: 11/29/2022
/// 
/// Timer script to control the oxygen timer
/// </summary>
public class Timer : MonoBehaviour
{
    //the TMP GUI element
    [SerializeField]public TextMeshProUGUI tmp;

    //Starting time and actual time variables
    public float startTime = 30f;
    float time;

    private void Start()
    {
        //setting the time to the starting level time
        time = startTime;
    }
    private void Update()
    {
        
        //checking if the time is great than zero
        if (time > 0)
        {
            //decreasing the time
            time -= Time.deltaTime;
        }
        else
        {
            //getting access to the GameManager object
            GameManager gm = GameObject.FindObjectOfType<GameManager>();
            //setting the time to zero after it reaches zero to avoid negative time
            time = 0;

            gm.GoToScene("EndOfGameLoss");
        }
        
        //Changing to color of the timer to red if the time is below 10 seconds
        if (time < 10)
        {
            tmp.color = Color.red;
        }
        else
        {
            tmp.color = Color.white;
        }


        //getting the minutes and seconds from the current time
        float minutes = Mathf.FloorToInt(time / 60);
        float seconds = Mathf.FloorToInt(time % 60);

        //setting the GUI text element to the current time
        tmp.text = string.Format("{0:00}:{1:00}", minutes, seconds);
    }

    /// <summary>
    /// Method to add time to the timer
    /// Used for the oxygen tank pickups
    /// </summary>
    /// <param name="amount">amount of time to be added</param>
    public void AddTime(float amount)
    {
        time += amount;
    }
}
