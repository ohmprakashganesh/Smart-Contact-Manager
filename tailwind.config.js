/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/main/resources/**/*.{html,js,jsx,tsx,ts}"],
  theme: {
    extend: {
      spacing: {
        '72': '18rem',
        '80': '20rem',
        '96': '24rem',
        '128': '32rem',
        '200': '50rem', // Custom large spacing
      },
    },
  },
  plugins: [],
  "darkMode":"selector"
}