import type { NextPage } from 'next'
import NavBar from "../components/NavBar.tsx"


const Home: NextPage = () => {
  return (
    <div>
    <NavBar/>
    <main>
    <h1> Welcome to BookMarker </h1>
    </main>
    </div>
  )
}

export default Home
