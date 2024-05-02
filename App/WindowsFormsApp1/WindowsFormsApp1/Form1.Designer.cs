
namespace WindowsFormsApp1
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.button4 = new System.Windows.Forms.Button();
            this.button1 = new System.Windows.Forms.Button();
            this.button2 = new System.Windows.Forms.Button();
            this.button3 = new System.Windows.Forms.Button();
            this.button5 = new System.Windows.Forms.Button();
            this.username_lbl = new System.Windows.Forms.Label();
            this.id_lbl = new System.Windows.Forms.Label();
            this.pass_lbl = new System.Windows.Forms.Label();
            this.email_lbl = new System.Windows.Forms.Label();
            this.id_txtbox = new System.Windows.Forms.MaskedTextBox();
            this.txt_email = new System.Windows.Forms.TextBox();
            this.name_txtbox = new System.Windows.Forms.TextBox();
            this.pass_txtbox = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // button4
            // 
            this.button4.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(192)))), ((int)(((byte)(0)))));
            this.button4.ForeColor = System.Drawing.SystemColors.ControlText;
            this.button4.Location = new System.Drawing.Point(573, 409);
            this.button4.Name = "button4";
            this.button4.Size = new System.Drawing.Size(143, 43);
            this.button4.TabIndex = 3;
            this.button4.Text = "button4";
            this.button4.UseVisualStyleBackColor = false;
            // 
            // button1
            // 
            this.button1.BackColor = System.Drawing.SystemColors.MenuHighlight;
            this.button1.Location = new System.Drawing.Point(88, 409);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(143, 43);
            this.button1.TabIndex = 4;
            this.button1.Text = "button1";
            this.button1.UseVisualStyleBackColor = false;
            // 
            // button2
            // 
            this.button2.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(192)))), ((int)(((byte)(64)))), ((int)(((byte)(0)))));
            this.button2.Location = new System.Drawing.Point(254, 409);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(143, 43);
            this.button2.TabIndex = 5;
            this.button2.Text = "button2";
            this.button2.UseVisualStyleBackColor = false;
            this.button2.Click += new System.EventHandler(this.button2_Click);
            // 
            // button3
            // 
            this.button3.BackColor = System.Drawing.Color.Yellow;
            this.button3.Location = new System.Drawing.Point(413, 409);
            this.button3.Name = "button3";
            this.button3.Size = new System.Drawing.Size(143, 43);
            this.button3.TabIndex = 6;
            this.button3.Text = "button3";
            this.button3.UseVisualStyleBackColor = false;
            this.button3.Click += new System.EventHandler(this.button3_Click);
            // 
            // button5
            // 
            this.button5.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(192)))), ((int)(((byte)(192)))));
            this.button5.Location = new System.Drawing.Point(733, 409);
            this.button5.Name = "button5";
            this.button5.Size = new System.Drawing.Size(143, 43);
            this.button5.TabIndex = 7;
            this.button5.Text = "button5";
            this.button5.UseVisualStyleBackColor = false;
            this.button5.Click += new System.EventHandler(this.button5_Click);
            // 
            // username_lbl
            // 
            this.username_lbl.AutoSize = true;
            this.username_lbl.Location = new System.Drawing.Point(93, 272);
            this.username_lbl.Name = "username_lbl";
            this.username_lbl.Size = new System.Drawing.Size(83, 20);
            this.username_lbl.TabIndex = 9;
            this.username_lbl.Text = "Username";
            // 
            // id_lbl
            // 
            this.id_lbl.AutoSize = true;
            this.id_lbl.Location = new System.Drawing.Point(93, 164);
            this.id_lbl.Name = "id_lbl";
            this.id_lbl.Size = new System.Drawing.Size(21, 20);
            this.id_lbl.TabIndex = 10;
            this.id_lbl.Text = "id";
            this.id_lbl.Click += new System.EventHandler(this.label3_Click);
            // 
            // pass_lbl
            // 
            this.pass_lbl.AutoSize = true;
            this.pass_lbl.Location = new System.Drawing.Point(93, 339);
            this.pass_lbl.Name = "pass_lbl";
            this.pass_lbl.Size = new System.Drawing.Size(78, 20);
            this.pass_lbl.TabIndex = 11;
            this.pass_lbl.Text = "Password";
            // 
            // email_lbl
            // 
            this.email_lbl.AutoSize = true;
            this.email_lbl.Location = new System.Drawing.Point(93, 217);
            this.email_lbl.Name = "email_lbl";
            this.email_lbl.Size = new System.Drawing.Size(48, 20);
            this.email_lbl.TabIndex = 12;
            this.email_lbl.Text = "Email";
            // 
            // id_txtbox
            // 
            this.id_txtbox.Location = new System.Drawing.Point(273, 158);
            this.id_txtbox.Name = "id_txtbox";
            this.id_txtbox.Size = new System.Drawing.Size(394, 26);
            this.id_txtbox.TabIndex = 13;
            // 
            // txt_email
            // 
            this.txt_email.BackColor = System.Drawing.SystemColors.HighlightText;
            this.txt_email.ForeColor = System.Drawing.Color.Black;
            this.txt_email.Location = new System.Drawing.Point(273, 214);
            this.txt_email.Name = "txt_email";
            this.txt_email.Size = new System.Drawing.Size(394, 26);
            this.txt_email.TabIndex = 14;
            // 
            // name_txtbox
            // 
            this.name_txtbox.Location = new System.Drawing.Point(273, 272);
            this.name_txtbox.Name = "name_txtbox";
            this.name_txtbox.Size = new System.Drawing.Size(394, 26);
            this.name_txtbox.TabIndex = 15;
            // 
            // pass_txtbox
            // 
            this.pass_txtbox.Location = new System.Drawing.Point(273, 336);
            this.pass_txtbox.Name = "pass_txtbox";
            this.pass_txtbox.Size = new System.Drawing.Size(394, 26);
            this.pass_txtbox.TabIndex = 16;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1106, 673);
            this.Controls.Add(this.pass_txtbox);
            this.Controls.Add(this.name_txtbox);
            this.Controls.Add(this.txt_email);
            this.Controls.Add(this.id_txtbox);
            this.Controls.Add(this.email_lbl);
            this.Controls.Add(this.pass_lbl);
            this.Controls.Add(this.id_lbl);
            this.Controls.Add(this.username_lbl);
            this.Controls.Add(this.button5);
            this.Controls.Add(this.button3);
            this.Controls.Add(this.button2);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.button4);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button button4;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.Button button3;
        private System.Windows.Forms.Button button5;
        private System.Windows.Forms.Label username_lbl;
        private System.Windows.Forms.Label id_lbl;
        private System.Windows.Forms.Label pass_lbl;
        private System.Windows.Forms.Label email_lbl;
        private System.Windows.Forms.MaskedTextBox id_txtbox;
        private System.Windows.Forms.TextBox txt_email;
        private System.Windows.Forms.TextBox name_txtbox;
        private System.Windows.Forms.TextBox pass_txtbox;
    }
}

