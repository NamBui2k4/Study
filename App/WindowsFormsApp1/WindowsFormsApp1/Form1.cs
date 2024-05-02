using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.SqlClient;
namespace WindowsFormsApp1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void button5_Click(object sender, EventArgs e)
        {

        }

        private void button3_Click(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            Boolean isAnyEmpty = false;
            foreach(Control c in this.Controls)
            {
                if(c is TextBox)
                {
                   if(c.Text.Length == 0)
                    {
                        isAnyEmpty = true;
                        break;
                    }
                }
            }
            if (isAnyEmpty)
            {
                MessageBox.Show("please fill the required form ", "info", MessageBoxButtons.OK,  MessageBoxIcon.Information);

            }
            else
            {
                SqlConnection con = new SqlConnection("Server=LAPTOP-ANKJ95OH\\SQLEXPRESS;Database=school;Integrated Security=True;");
                con.Open();
                string insertQuery = "INSERT INTO school (email, name, password) VALUES (@email, @name, @password)";
                SqlCommand cmd = new SqlCommand(insertQuery, con);
                cmd.Parameters.AddWithValue("@email", txt_email.Text);
                cmd.Parameters.AddWithValue("@email", name_txtbox.Text);
                cmd.Parameters.AddWithValue("@email", pass_txtbox.Text);
                int count = cmd.ExecuteNonQuery();
                con.Close();
                if(count > 0)
                {
                    MessageBox.Show("create successfully", "info", MessageBoxButtons.OK, MessageBoxIcon.Information);

                }
                else
                {
                    MessageBox.Show("Error in creation", "info", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }


            }
        }
    }
}
