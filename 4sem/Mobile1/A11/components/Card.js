import { View, Image, Text } from 'react-native';

import styles from '../estilos.js'

export default function Card({contato})
{
    return (
      <View style={styles.card}>
        <Image
          source={{ uri: contato.avatarURL }}
          style={styles.avatar}
          resizeMode="cover"
        />

        <Text style={styles.nome}>
          {contato.nome}
        </Text>

        <Text style={styles.cidade}>
          {contato.cidade}
        </Text>

      </View>
    )
}