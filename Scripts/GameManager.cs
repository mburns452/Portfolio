using System.Collections;
using System.Collections.Generic;
using TMPro;
using UnityEngine;
using UnityEngine.SceneManagement;
/// <summary>
/// Author: Mason Burns
/// Date: 11/29/2022
/// 
/// GameManager script that handles some of the games core functions
/// </summary>
public class GameManager : MonoBehaviour
{
    //Getting the pauseMenu object
    [SerializeField] GameObject pauseMenu;
    //bool for whether the game is paused or not
    public static bool isPaused = false;


    private void Update()
    {
        if (Input.GetKeyDown(KeyCode.Escape))
        {
            if (isPaused)
            {
                Resume();
            }
            else
            {
                Pause();
            }
        }
    }

    /// <summary>
    /// Method to resume the game after the resume button or escape key is hit
    /// </summary>
    public void Resume()
    {
        pauseMenu.SetActive(false);
        Time.timeScale = 1f;
        isPaused = false;
    }
    /// <summary>
    /// Method to pause the game after the escape key is pressed
    /// </summary>
    void Pause()
    {
        pauseMenu.SetActive(true);
        Time.timeScale = 0f;
        isPaused = true;
    }
    
    
    /// <summary>
    /// Method to go to a scene by name
    /// </summary>
    /// <param name="name">name of the scene to go to</param>
    public void GoToScene(string name)
    {
        //checking if the scene exists
        if (name != null)
        {
            SceneManager.LoadScene(name);
        }
    }
    /// <summary>
    /// Method to quit the game
    /// </summary>
    public void QuitGame()
    {
        Application.Quit();
    }
}
