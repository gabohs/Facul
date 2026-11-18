import {Text, View, FlatList} from 'react-native';

import Card from './components/Card.js';

import styles from './estilos.js';

import contatos from './dados.json';

export default function App() {
    return (
      <View style={styles.container}>

          <Text style={styles.titulo}>Meus Contatos</Text>

          <FlatList
            data={contatos}

            renderItem={({ item }) => (
              <Card contato={item} />
            )}

            keyExtractor={(item) => item.nome}

            numColumns={2}

            columnWrapperStyle={styles.linha}

            contentContainerStyle={styles.lista}
          />

      </View>
    )
}
