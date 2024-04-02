using Microsoft.AspNetCore.Mvc;

namespace SampleMVCApps.Controller
{
    public class HelloWorld : Controller
    {
        public IActionResult Index()
        {
            ViewData["Message"] = "Hello, this is my view";
            return View();
        }

        public IActionResult Wellcome()
        {
            ViewData["Message"] = " Hello, Welcome to HelloWorld Application";
            return View();
        }
    }
}