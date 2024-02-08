using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;
/// <summary>
/// Author: Mason Burns
/// Date: 11/29/2022
/// 
/// Portal script to control the portal's behavior after the player reaches it.
/// </summary>
public class Portal : MonoBehaviour
{
    private void OnTriggerEnter2D(Collider2D collision)
    {
        //Getting access to the GameManager object
        GameManager gm = GameObject.FindObjectOfType<GameManager>();
        //if the tag of the object touching the portal is the player
        if (collision.tag == "Player")
        {
            //Going to the next level i.e. You win the level
            SceneManager.LoadScene(SceneManager.GetActiveScene().buildIndex + 1);
        }
    }
}
